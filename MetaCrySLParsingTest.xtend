package br.unb.cic.mcsl.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Ignore

@RunWith(XtextRunner)
@InjectWith(MetaCrySLInjectorProvider)
class MetaCrySLParsingTest extends MetaCrySLAbstractTests {
		@Test
	def void basicModel() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModel.cryptsl + "basicModel.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithForbiddenClause() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithForbiddenClause.cryptsl + "basicModelWithForbiddenClause.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithAdditionalConstraintsClause() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithAdditionalConstraintsClause.cryptsl + "basicModelWithAdditionalConstraintsClause.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithOrderClause() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithOrderClause.cryptsl + "basicModelWithOrderClause.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithTypeObject() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithTypeObject.cryptsl + "basicModelWithTypeObject.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithoutAbstract() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithoutAbstract.cryptsl + "basicModelWithoutAbstract.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
	@Test
	def void basicModelWithConstraintsClause() {
		val file = super.readFileIntoString(/home/vinicius/metacrysl/MCSLTestGeneration/mcsl_test_generation/target/test-classes/unit/sample01/rules/basicModelWithConstraintsClause.cryptsl + "basicModelWithConstraintsClause.cryptsl")
		
		val result = super.parseHelper.parse(file)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: «errors.join(", ")»''', !errors.isEmpty)
	}
}
