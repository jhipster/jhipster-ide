package ch.itemis.xdocker.app.xdockerscout.client.util;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm;
import ch.itemis.xdocker.app.xdockerscout.client.util.DialogForm.MainBox.MessageField;

/**
 * <h3>{@link XdockerEditorForm}</h3>
 *
 * @author serano
 */
public class DialogForm extends AbstractForm implements IPageForm {

	private IForm parentForm = null;

	public DialogForm(String title) {
		setHandler(new ViewHandler());
		setTitle(title);
	}

	@Override
	public void startPageForm(IForm parentForm) {
		this.parentForm = parentForm;
		startInternal(new ViewHandler());
	}

	public MessageField getMessageField() {
		return getFieldByClass(MessageField.class);
	}

	public IForm getParentForm() {
		return parentForm;
	}

	@Override
	protected boolean getConfiguredAskIfNeedSave() {
		return false;
	}

	@Order(1000)
	public class MainBox extends AbstractGroupBox {

		@Override
		protected int getConfiguredGridH() {
			return 10;
		}

		@Override
		protected int getConfiguredGridW() {
			return 10;
		}

		@Override
		protected boolean getConfiguredLabelVisible() {
			return false;
		}

		@Override
		protected String getConfiguredLabel() {
			return "Choose Docker File...";
		}

		@Order(-1000)
		public class MessageField extends AbstractStringField {
			@Override
			protected String getConfiguredLabel() {
				return "Message"; // TEXTS.get("MyNlsKey");
			}
		}
		
		@Order(50)
		public class CloseButton extends AbstractCloseButton {
		}
	}

	public class ViewHandler extends AbstractFormHandler {
	}
}
