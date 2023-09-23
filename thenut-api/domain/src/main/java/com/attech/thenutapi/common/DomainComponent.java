package com.attech.thenutapi.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The DomainComponent annotation is used to mark classes as domain components within the hexagonal architecture of the Thenut API.
 * <p>
 * Domain components are fundamental building blocks of the domain model and encapsulate domain-specific logic and behavior.
 * They are typically annotated with this annotation to distinguish them within the application.
 * <p>
 * This annotation is intended to provide clarity and organization in the codebase, making it easier to identify and categorize
 * domain-related components.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DomainComponent {
}
