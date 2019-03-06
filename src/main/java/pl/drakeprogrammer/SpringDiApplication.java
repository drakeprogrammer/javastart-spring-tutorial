package pl.drakeprogrammer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringDiApplication implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
		dynamic.addMapping("/");
	}
}
