package com.calsoftinc.jhipstersample;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.calsoftinc.jhipstersample");

        noClasses()
            .that()
            .resideInAnyPackage("com.calsoftinc.jhipstersample.service..")
            .or()
            .resideInAnyPackage("com.calsoftinc.jhipstersample.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.calsoftinc.jhipstersample.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
