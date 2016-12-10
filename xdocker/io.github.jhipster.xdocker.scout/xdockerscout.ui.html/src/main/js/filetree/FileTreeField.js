scout.FileTreeField = function() {
  scout.FileTreeField.parent.call(this);
};
scout.inherits(scout.FileTreeField, scout.FormField);

scout.FileTreeField.prototype._render = function($parent) {
  this.addContainer($parent, 'filetree-field');
  this.addLabel();
  this.addStatus();

  var filetreeId = scout.objectFactory.createUniqueId();
  var $fieldContent = this.$container.makeDiv('filetree').attr('id', filetreeId);

  var field = this;  
  var rootFolder = field.rootFolder.value;
 
  this._folderContents = new Map(); // depends on browser
  this._fileTree = $fieldContent.fileTree({
      root: rootFolder,
      script: function(data) {
        return field._handleFolderClicked(data);
      },
      collapseSpeed: field.collapseSpeed,
      multiFolder: field.multiFolder
    },
    function(file) {
      field._handleFileClicked(file);
    })[0];
  this._$fileTree = $(this._fileTree);
  this._fileTreeInstance = this._$fileTree.data('fileTree');

  this.addField($fieldContent);
};

scout.FileTreeField.prototype._renderProperties = function() {
  scout.FileTreeField.parent.prototype._renderProperties.call(this);
  this._renderExpandSpeed();
  this._renderCollapseSpeed();
  this._renderMultiFolder();
};

scout.FileTreeField.prototype._remove = function() {
  scout.FileTreeField.parent.prototype._remove.call(this);
  this._$fileTree = null;
  this._fileTreeInstance = null;
  this._folderContents.clear();
  this._folderContents = null;
  this._fileTree = null;
};

scout.FileTreeField.prototype._handleFolderClicked = function(folder) {
  if (!this._fileTree) {
    return this._wrapWithUl(this._makeLi({
      isDir: true,
      isCollapsed: true,
      name: this.label,
      path: folder.dir
    }));
  }

  var $clickedObjParent = this._getElement(folder.dir).parent();
  if (this._folderContents.has(folder.dir)) {
    $clickedObjParent.removeClass('waitForCallback').addClass('directory').addClass('expanded');
    var treeFieldElementArr = this._folderContents.get(folder.dir);
    if (treeFieldElementArr && treeFieldElementArr.length > 0) {
      var index;
      var itemStr = '';
      for (index = 0; index < treeFieldElementArr.length; index++) {
        itemStr += this._makeLi(treeFieldElementArr[index]);
      }
      return this._wrapWithUl(itemStr);
    }
    return '';
  } else {
    $clickedObjParent.addClass('waitForCallback').removeClass('directory').removeClass('expanded');
    this._send('folderClicked', folder);
    return '';
  }
};

scout.FileTreeField.prototype._makeLi = function(attribs) {
  var cssClass;
  if (attribs.isDir) {
    cssClass = 'directory';
    if (attribs.isCollapsed) {
      cssClass += ' collapsed';
    } else {
      cssClass += ' expanded';
    }
  } else {
    cssClass = 'file';
    var ext = '';
    var pos = attribs.name.lastIndexOf('.');
    if (pos >= 0) {
      ext = attribs.name.substring(pos + 1, attribs.name.length);
    }
    if (ext) {
      cssClass += ' ext_' + ext;
    }
  }
  var attribsName = scout.strings.encode(attribs.name);
  return '<li class="' + cssClass + '"><a href="#" rel="' + attribs.path + '">' + attribsName + '</a></li>';
};

scout.FileTreeField.prototype._wrapWithUl = function(str) {
  return '<ul class="jqueryFileTree">' + str + '</ul>';
};

scout.FileTreeField.prototype._getElement = function(dir) {
  return this._$fileTree.find("a[rel='" + dir + "']").first();
};

//scout.ModelAdapter.prototype._syncExpandSpeed = function(expandSpeed) {
//  this.expandSpeed = expandSpeed;
//};

scout.FileTreeField.prototype._renderExpandSpeed = function() {
  this._fileTreeInstance.options.expandSpeed = this.expandSpeed;
};

scout.FileTreeField.prototype._renderCollapseSpeed = function() {
  this._fileTreeInstance.options.collapseSpeed = this.collapseSpeed;
};

scout.FileTreeField.prototype._renderMultiFolder = function() {
  this._fileTreeInstance.options.multiFolder = this.multiFolder;
};

scout.FileTreeField.prototype._onFolderContentLoaded = function(event) {
  var $clickedObj = this._getElement(event.dir);
  this._folderContents.set(event.dir, event.content);
  this._fileTreeInstance.showTree($clickedObj.parent(), event.dir, function() {
    this._fileTreeInstance._trigger('filetreeexpanded', this._fileTreeInstance.data);
  }.bind(this));
};

scout.FileTreeField.prototype._handleFileClicked = function(file) {
  this._send('fileClicked', {
    path: file
  });
};

scout.FileTreeField.prototype.onModelAction = function(event) {
  if (event.type === 'folderLoaded') {
    this._onFolderContentLoaded(event);
  } else {
    scout.FileTreeField.parent.prototype.onModelAction.call(this, event);
  }
};
