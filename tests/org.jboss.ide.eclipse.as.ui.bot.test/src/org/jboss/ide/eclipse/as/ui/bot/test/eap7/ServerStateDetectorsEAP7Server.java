package org.jboss.ide.eclipse.as.ui.bot.test.eap7;

import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerReqVersion;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerReqType;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.ide.eclipse.as.ui.bot.test.template.ServerStateDetectorsTemplate;
import org.jboss.reddeer.requirements.server.ServerReqState;

@JBossServer(state=ServerReqState.STOPPED, type=ServerReqType.EAP7x, version=ServerReqVersion.EQUAL)
public class ServerStateDetectorsEAP7Server extends ServerStateDetectorsTemplate {

	@Override
	protected String getManagerServicePoller() {
		return "JBoss 7 Manager Service";
	}
}
