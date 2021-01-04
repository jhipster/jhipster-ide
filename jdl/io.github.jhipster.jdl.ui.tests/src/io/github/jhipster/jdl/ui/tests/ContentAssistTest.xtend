/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ui.tests

import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Serano Colameo - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(JDLUiInjectorProvider)
class ContentAssistTest extends AbstractContentAssistTest {

	val cursor = '''<|>'''

	private def void testContentAssistant(CharSequence text, List<String> expectedProposals) {
		val cursorPosition = text.toString.indexOf(cursor)
		val content = text.toString.replace(cursor, '')		
		newBuilder.append(content).assertTextAtCursorPosition(cursorPosition, expectedProposals)
	}

	@Test def void testTestFrameworksWithoutBrackets() {
		'''
			application {
			  config {
			    testFrameworks «cursor»
			  }
			}
		'''.testContentAssistant(#['[protractor, cucumber, gatling]'])
	}

	@Test def void testTestFrameworksWithLeftBracket() {
		'''
			application {
			  config {
			    testFrameworks [«cursor»]
			  }
			}
		'''.testContentAssistant(#['protractor, cucumber, gatling'])
	}

    @Test def void testDisplayFieldForSourceRole() {
        '''
            entity C {
              nameC String
            }
            
            entity F {
              count Integer
            }
            
            relationship ManyToMany {
                C{name(«cursor»)} to F{aa(nameC)}
            }
        '''.testContentAssistant(#['(', 'count'])
    }

    @Test def void testDisplayFieldForTargetRole() {
        '''
            entity C {
              nameC String
            }
            
            entity F {
              count Integer
            }
            
            relationship ManyToMany {
                C{name(count)} to F{aa(«cursor»)}
            }
        '''.testContentAssistant(#['(', 'nameC'])
    }

	@Test def void testEntityTemplateProposal() {
		newBuilder.applyProposal("Entity - template for an Entity").expectContent('''

		/** 
		 * Entity name
		 */
		entity name {
			fieldName fieldType
			
		}''')
	}

	@Test def void testApplicationTemplateProposal() {
		newBuilder.applyProposal("Application - template for a application configuration").expectContent('''
		/** 
		 * Application configuration section
		 */
		application {
			config {
				
			}
		}''')
	}

	@Test def void testWithSkipUserManagement() {
		''' // skip-user-management
            entity A {
              name String
            }
                        
            relationship ManyToMany {
                A to U«cursor»
            }
        '''.testContentAssistant(#[',', '@', '{', '}'])
	}

	@Test def void testWithoutSkipUserManagement() {
		''' 
            entity A {
              name String
            }
                        
            relationship ManyToMany {
                A to U«cursor»
            }
        '''.testContentAssistant(#[',', 'User', '@', '{', '}'])
	}
}
