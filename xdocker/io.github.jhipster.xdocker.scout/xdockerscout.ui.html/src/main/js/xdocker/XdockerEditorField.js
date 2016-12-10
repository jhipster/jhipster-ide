scout.XdockerEditorField = function() {
	scout.XdockerEditorField.parent.call(this);
};

scout.inherits(scout.XdockerEditorField, scout.ValueField);

scout.XdockerEditorField.prototype._render = function($parent) {
	this.addContainer($parent, 'xdocker-editor-field');
	//	this.addLabel(); // no label on the left
	this.addStatus();

	var $field = this.$container
			.makeDiv('xdocker-editor-field')
			.attr('id', 'xtext-editor')
			.attr('data-editor-xtext-lang', 'xdocker');
	this.addField($field);

	var baseUrl = this.serverUrl.value + '/';

	require.config({
		baseUrl : baseUrl,
		paths : {
			"jquery" : "webjars/jquery/2.1.4/jquery.min",
			"ace/ext/language_tools" : "webjars/ace/1.2.0/src/ext-language_tools",
			"xtext/xtext-ace" : "xtext/2.10.0/xtext-ace"
		}
	});
	
	require([ "webjars/ace/1.2.0/src/ace" ], function() {
		require([ "xtext/xtext-ace" ], function(xtext) {
			this.editor = xtext.createEditor({
				baseUrl : baseUrl,
				serviceUrl : baseUrl + 'xtext-service',
				sendFullText : true,
				syntaxDefinition : "xtext-resources/generated/mode-xdocker"
			});			
//			var editor = xtext.createEditor({syntaxDefinition: "xtext/ace-mode-statemachine"});
			$("#save-button").click(function() {
				this.editor.xtextServices.saveResource();
			});
			$("#revert-button").click(function() {
				editor.xtextServices.revertResource();
			});
			$("#generate-button").click(function() {
				window.open('http://' + location.host + '/xtext-service/generate?resource=' + editor.xtextServices.options.resourceId);
			});
			$("#change-resource").change(function() {
				var resourceId = $("#change-resource option:selected").attr("value");
				this.editor.xtextServices.serviceBuilder.changeResource(resourceId);
			});
			$("#disable-button").click(function() {
				xtext.removeServices(editor);
			});
			this._renderDisplayText();
		}.bind(this));
	}.bind(this));
/*	
	require(["webjars/ace/1.2.0/src/ace"], function() {
		require(["xtext/xtext-ace"], function(xtext) {
			var editor = xtext.createEditor({syntaxDefinition: "xtext/ace-mode-statemachine"});
			$("#save-button").click(function() {
				editor.xtextServices.saveResource();
			});
			$("#revert-button").click(function() {
				editor.xtextServices.revertResource();
			});
			$("#generate-button").click(function() {
				window.open('http://' + location.host + '/xtext-service/generate?resource=' + editor.xtextServices.options.resourceId);
			});
			$("#change-resource").change(function() {
				var resourceId = $("#change-resource option:selected").attr("value");
				editor.xtextServices.serviceBuilder.changeResource(resourceId);
			});
			$("#disable-button").click(function() {
				xtext.removeServices(editor);
			});
		});
	});	
*/	
};

scout.XdockerEditorField.prototype._renderDisplayText = function() {
	if (this.editor) {
		this.editor.setValue(this.displayText);
	}
};

scout.XdockerEditorField.prototype._readDisplayText = function() {
	if (this.editor) {
		return this.editor.getValue();
	}
	return null;
};
