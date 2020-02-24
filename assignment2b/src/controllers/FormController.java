package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped
public class FormController {

	public String onSubmit() {

		// creates the instance of context
		FacesContext context = FacesContext.getCurrentInstance();

		// this will get the values from the import form and pass them into User.class
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// System.out.println("THE BUTTON WAS CLICKED");

		// this will put the user object into the POST
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

		// this will return the result into the TestForm page
		return "TestResponse.xhtml";
	}

	public String onFlash() {

		// creates the instance of context
		FacesContext context = FacesContext.getCurrentInstance();

		// this will get the values from the import form and pass them into User.class
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		//System.out.println("THE FLASH WAS CLICKED");

		// this will put the user object into the POST
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);

		// this will return the result into the TestForm page

		return "TestResponse2.xhtml";
	}

}
