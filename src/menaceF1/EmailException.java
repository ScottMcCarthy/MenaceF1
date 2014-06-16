/*
 * Created on 06-Jul-05
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package menaceF1;

/*
*Exception subclass for use by EmailSender
*
*Version History:
*22/11/2002 V1.0 AS Initial release
*
*/
public class EmailException extends RuntimeException {

	public static final long serialVersionUID = 1;

	public EmailException() {
		super();
	}
	public EmailException(String s) {
		super(s);
	}
}
