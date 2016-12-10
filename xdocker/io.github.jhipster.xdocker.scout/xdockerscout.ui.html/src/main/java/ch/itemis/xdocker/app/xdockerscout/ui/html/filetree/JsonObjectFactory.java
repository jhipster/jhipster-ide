package ch.itemis.xdocker.app.xdockerscout.ui.html.filetree;

import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.ui.html.IUiSession;
import org.eclipse.scout.rt.ui.html.json.AbstractJsonObjectFactory;
import org.eclipse.scout.rt.ui.html.json.IJsonAdapter;

import ch.itemis.xdocker.app.xdockerscout.client.filetree.IFileTreeField;

@Bean
@Order(100)
public class JsonObjectFactory extends AbstractJsonObjectFactory {
  @Override
  public IJsonAdapter<?> createJsonAdapter(Object model, IUiSession session, String id, IJsonAdapter<?> parent) {
    if (model instanceof IFileTreeField) {
      return new JsonFileTreeField((IFileTreeField) model, session, id, parent);
    }
    return null;
  }
}
