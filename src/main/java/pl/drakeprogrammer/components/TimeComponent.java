package pl.drakeprogrammer.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimeComponent {

	private long currentTime;

	public TimeComponent() {
		this.currentTime = System.currentTimeMillis();
	}

	public long getCurrentTime() {
		return currentTime;
	}

	@PostConstruct
	public void afterCreated() {
		System.out.println(this + " created");
	}

	@PreDestroy
	public void beforeDestroy() {
		System.out.println(this + " destroyed");
	}

}
