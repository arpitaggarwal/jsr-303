package com.arpit.jsr.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.arpit.jsr.model.Address;

@Validated
public interface IPersonService {

	/**
	 * Moving constraints to interface to avoid ConstraintDeclarationException
	 * as this exception is raised if you add parameter constraints to a method
	 * which overrides or implements a super-type method. This behavior is
	 * mandated by the Bean Validation spec (see
	 * http://beanvalidation.org/1.1/spec/#constraintdeclarationvalidationprocess-methodlevelconstraints-inheritance) in order to obey to the Liskov
	 * substitution principle.
	 * 
	 * 
	 * Quote: In sub types (be it sub classes/interfaces or interface
	 * implementations), no parameter constraints may be declared on overridden
	 * or implemented methods, nor may parameters be marked for cascaded
	 * validation. This would pose a strengthening of preconditions to be
	 * fulfilled by the caller.
	 * 
	 * @param name
	 * @param address
	 * @return
	 */
	Address add(@Valid @NotNull @Size(min = 1) String name,
			@Valid Address address);

}
