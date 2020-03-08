package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {

	@Inject
	OrdersBusinessInterface services;

	@EJB
	MyTimerService timer;

	public String onSubmit() {

		// creates the instance of context
		FacesContext context = FacesContext.getCurrentInstance();

		// this will get the values from the import form and pass them into User.class
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// Will print out a message to the console which will tell us which business
		// service is currently selected in the beans.xml file as an Alternative
		services.test();

		// star a timer when the login is clicked
		timer.setTimer(5000);

		// this will put the user object into the POST
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

		// this will return the result into the TestForm page
		return "TestResponse.xhtml";
	}

	public OrdersBusinessInterface getService() {

		return services;

	}

	public String onFlash() {

		// creates the instance of context
		FacesContext context = FacesContext.getCurrentInstance();

		// this will get the values from the import form and pass them into User.class
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// System.out.println("THE FLASH WAS CLICKED");

		// this will put the user object into the POST
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);

		// this will return the result into the TestForm page

		return "TestResponse2.xhtml";
	}

}
