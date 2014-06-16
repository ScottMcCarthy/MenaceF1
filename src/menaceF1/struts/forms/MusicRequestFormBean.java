package menaceF1.struts.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 3 fields on this form:
 * <ul>
 * <li>artist - Name of Artist
 * <li>song - Name of Song
 * <li>guest - Guest name submitting this request
 * </ul>
 * @version 	1.0
 * @author		Scott McCarthy
 */
public class MusicRequestFormBean extends ActionForm

{
	public static final long serialVersionUID = 1;
    private String artist = null;
    private String song = null;
    private String guest = null;

    /**
     * Get artist
     * @return String
     */
    public String getArtist() {
	return artist;
    }

    /**
     * Set artist
     * @param <code>String</code>
     */
    public void setArtist(String a) {
	this.artist = a;
    }

    /**
     * Get song
     * @return String
     */
    public String getSong() {
	return song;
    }

    /**
     * Set song
     * @param <code>String</code>
     */
    public void setSong(String s) {
	this.song = s;
    }

    /**
     * Get guest
     * @return String
     */
    public String getGuest() {
	return guest;
    }

    /**
     * Set guest
     * @param <code>String</code>
     */
    public void setGuest(String g) {
	this.guest = g;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset values are provided as samples only. Change as appropriate.

	artist = null;
	song = null;
	guest = null;

    }

    public ActionErrors validate(ActionMapping mapping,
	    HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	 if ((artist == null) || (artist.length() == 0)) {
		   errors.add("blankArtist", new org.apache.struts.action.ActionError("errors.blankArtist"));
		 }
	 if ((song == null) || (song.length() == 0)) {
		   errors.add("blankSong", new org.apache.struts.action.ActionError("errors.blankSong"));
		 }
	 if ((guest == null) || (guest.length() == 0)) {
		   errors.add("blankName", new org.apache.struts.action.ActionError("errors.blankName"));
		 }
	return errors;

    }
}
