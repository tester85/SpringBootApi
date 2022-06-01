package api.example.noauth.service;

import org.springframework.context.ApplicationEvent;

public class AgencyPromotionalEvent extends ApplicationEvent{

	public AgencyPromotionalEvent(Object source) {
		super(source);
	}
	
	public String toString() {
        return "My Promotional Event";
    }
	
	
}
