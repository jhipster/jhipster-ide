package ch.itemis.xdocker.app.xdockerscout.server.service;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.eclipse.scout.rt.testing.server.runner.RunWithServerSession;
import org.eclipse.scout.rt.testing.server.runner.ServerTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.itemis.xdocker.app.xdockerscout.server.ServerSession;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerEditorFormService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerEditorFormData;

/**
 * <h3>{@link XdockerFormServiceTest}</h3>
 *
 * @author serano
 */
@RunWith(ServerTestRunner.class)
@RunWithSubject(XdockerFormServiceTest.SUBJECT_NAME)
@RunWithServerSession(ServerSession.class)
public class XdockerFormServiceTest {
	public static final String SUBJECT_NAME = "test_subject";

	@Test
	public void testMessageContainsSubjectName() {
		XdockerEditorFormData input = new XdockerEditorFormData();
		input = BEANS.get(IXdockerEditorFormService.class).load(input);
		Assert.assertNotNull(input.getXdockerEditor());
	}
}
