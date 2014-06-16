package menaceF1.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import menaceF1.struts.forms.HotelBookingFormBean;
import menaceF1.wedding.Accomodation;

/**
 * @version 	1.0
 * @author
 */
public class CompleteBookingAction extends Action

{
	private float paypalPercentage = 3;
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward(); 
    if (request.getSession().getAttribute("WEDDINGGUEST")== null){
    	return mapping.findForward("sessionExpired");
    }
	HotelBookingFormBean hotelBookingFormBean = (HotelBookingFormBean) form;

	try {
	    //calculate total cost
		float cost = Float.parseFloat(hotelBookingFormBean.getRoomcost());
		if (hotelBookingFormBean.getPaymentMethod().equalsIgnoreCase("paypal")) {
			cost = cost + ((cost*paypalPercentage)/100);
		}
		if (hotelBookingFormBean.getNights().equalsIgnoreCase("2")) cost = cost*2;
		hotelBookingFormBean.setRoomcost(""+cost);
		Accomodation thisHotel = new Accomodation();
	    if (thisHotel.isRoomStillAvailable(hotelBookingFormBean.getRoomID())) {
	    	thisHotel.submitBooking(hotelBookingFormBean);
	    	forward = mapping.findForward("success");
	    } else {
	    	forward = mapping.findForward("soldOut");
	    }
	    request.getSession().setAttribute("BOOKINGFORM", hotelBookingFormBean);
	    request.getSession().setAttribute("BOOKINGREF", thisHotel.getMaxBookingNumber());
	    request.getSession().setAttribute("PAYMENTTYPE", hotelBookingFormBean.getPaymentMethod());
	    request.getSession().setAttribute("PAYMENTCOST", hotelBookingFormBean.getRoomcost());

	} catch (Exception e) {

		forward = mapping.findForward("failed");

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	}

	// Finish with
	return (forward);

    }
}
