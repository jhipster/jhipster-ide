package ch.itemis.xdocker.app.xdockerscout.shared.util

import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerContainerInfo
import java.util.Arrays
import java.util.Collection
import java.util.Map

class XdockerContainerMatcher {

	def static boolean match(String term, XdockerContainerInfo it) {
		if (it == null) {
			return false;
		} else if (term.isNullOrEmpty) {
			return true;
		} else {
			return term != null && image != null &&
				(contains(image, term) || contains(command, term) || 
					contains(id, term) || (contains(names, term)) ||
					(contains(ports, term)) || (contains(labels, term)));
		}
	}

	def static boolean contains(String value, String term) {
		return value != null && value.contains(term)
	}

	def static boolean contains(XdockerContainerInfo.Port[] ports, String term) {
		for (XdockerContainerInfo.Port port : ports) {
			if (contains(port.toString(), term))
				return true
		}
		return false
	}

	def static boolean contains(String[] values, String term) {
		return contains(Arrays.asList(values), term)
	}

	def static boolean contains(Map<String, String> map, String term) {
		if (map == null)
			return false
		if (contains(map.values(), term) || contains(map.keySet(), term))
			return true
		return false
	}

	def static boolean contains(Collection<String> values, String term) {
		if (values == null)
			return false
		for (String value : values) {
			if (contains(value, term))
				return true
		}
		return false
	}
}
