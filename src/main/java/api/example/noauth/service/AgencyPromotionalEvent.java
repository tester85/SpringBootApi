package api.example.noauth.service;

import org.springframework.context.ApplicationEvent;

public class AgencyPromotionalEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6804885449405026784L;

	public AgencyPromotionalEvent(Object source) {
		super(source);
	}
	
	public String toString() {
        return "My Promotional Event";
    }
	
	
}
