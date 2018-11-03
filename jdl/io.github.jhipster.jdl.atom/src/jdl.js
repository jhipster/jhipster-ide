const {AutoLanguageClient} = require('atom-languageclient')
const path = require("path");
const os = require("os");
const { spawn } = require('child_process');
//const process = require('process');

class JdlLanguageClient extends AutoLanguageClient {
  getGrammarScopes () { return [ 'source.jdl' ] }
  getLanguageName () { return 'jdl' }
  getServerName () { return 'JDL Language Server' }
  getConnectionType() { return 'stdio' }
//  process.env['XTEXT_SERVER_JDL_OPTS'] = "-Dpnguml.gen=true -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9999,suspend=n,quiet=y";
  startServerProcess () {
    let launcher = os.platform() === 'win32' ? 'xtext-server-jdl.bat' : 'xtext-server-jdl'
    let lsDir = atom.packages.resolvePackagePath(path.join("ide-jhipster", "xtext-server-jdl", "bin"))
    return spawn(path.join(lsDir, launcher));
  }
}

var server = new JdlLanguageClient()
module.exports = server
