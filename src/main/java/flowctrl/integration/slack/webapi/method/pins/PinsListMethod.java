package flowctrl.integration.slack.webapi.method.pins;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class PinsListMethod extends AbstractMethod {

	public PinsListMethod(String channel) {
		this.channel = channel;
	}

	protected String channel;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.PINS_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
	}

}
