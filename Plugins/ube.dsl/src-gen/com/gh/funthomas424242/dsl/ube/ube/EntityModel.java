/**
 */
package com.gh.funthomas424242.dsl.ube.ube;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.gh.funthomas424242.dsl.ube.ube.EntityModel#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.gh.funthomas424242.dsl.ube.ube.UbePackage#getEntityModel()
 * @model
 * @generated
 */
public interface EntityModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link com.gh.funthomas424242.dsl.ube.ube.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see com.gh.funthomas424242.dsl.ube.ube.UbePackage#getEntityModel_Types()
   * @model containment="true"
   * @generated
   */
  EList<Type> getTypes();

} // EntityModel
