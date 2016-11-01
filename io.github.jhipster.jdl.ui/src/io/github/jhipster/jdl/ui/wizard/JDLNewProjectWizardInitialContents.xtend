package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.resource.FileExtensionProvider

class JDLNewProjectWizardInitialContents {

	@Inject FileExtensionProvider fileExtensionProvider

	def generateInitialContents(IFileSystemAccess2 fsa) {
		fsa.generateFile(
			"src/model/Model." + fileExtensionProvider.fileExtensions.last,
			'''
				/*
				 * This is an example model
				 */
				entity Address {
					street String required,
					streetNr Integer required,
					city String required,
					zip Integer required,
					country String
				}
				
				entity Person {
					fristName String required,
					lastName String required,
					gender Gender
				}
				
				enum Gender {
					Male, Female, Other
				}
				
				relationship ManyToMany {
					Person to Address
				}
				
				dto * with mapstruct except User
				service * with serviceClass except User
			'''
		)
	}
}
