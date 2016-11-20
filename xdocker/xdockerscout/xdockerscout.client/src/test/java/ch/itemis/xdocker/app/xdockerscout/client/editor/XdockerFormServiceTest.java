package ch.itemis.xdocker.app.xdockerscout.client.editor;

import org.eclipse.scout.rt.client.testenvironment.TestEnvironmentClientSession;
import org.eclipse.scout.rt.testing.client.runner.ClientTestRunner;
import org.eclipse.scout.rt.testing.client.runner.RunWithClientSession;
import org.eclipse.scout.rt.testing.platform.mock.BeanMock;
import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;

import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerEditorFormService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerEditorFormData;

/**
 * <h3>{@link XdockerFormServiceTest}</h3> Contains Tests for the
 * {@link XdockerEditorForm}.
 *
 * @author serano
 */
@RunWith(ClientTestRunner.class)
@RunWithSubject("anonymous")
@RunWithClientSession(TestEnvironmentClientSession.class)
public class XdockerFormServiceTest {

	private static final String MESSAGE_VALUE = "# some data";

	// Register a mock service for {@link IHelloWorldFormService}
	@BeanMock
	private IXdockerEditorFormService m_mockSvc;

	/**
	 * Return a reference {@link XdockerEditorFormData} on method
	 * {@link IXdockerEditorFormService#load(XdockerEditorFormData)}.
	 */
	@Before
	public void setup() {
		XdockerEditorFormData result = new XdockerEditorFormData();
		result.getXdockerEditor().setValue(MESSAGE_VALUE);
		Mockito.when(m_mockSvc.load(Matchers.any(XdockerEditorFormData.class))).thenReturn(result);
	}

	/**
	 * Tests that the {@link MessageField} is enabled.
	 */
	@Test
	public void testMessageFieldEnabled() {
		XdockerEditorForm frm = new XdockerEditorForm();
		Assert.assertTrue(frm.getXdockerEditorField().isVisible());
	}

	/**
	 * Tests that the {@link MessageField} is correctly filled after start.
	 */
	@Test
	public void testMessageCorrectlyImported() {
		XdockerEditorForm frm = new XdockerEditorForm();
		frm.start();
		Assert.assertEquals("", frm.getXdockerEditorField().getValue());
	}
}
