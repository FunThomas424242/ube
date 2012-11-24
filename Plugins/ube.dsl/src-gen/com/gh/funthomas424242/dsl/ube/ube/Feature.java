/**
 */
package com.gh.funthomas424242.dsl.ube.ube;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.gh.funthomas424242.dsl.ube.ube.Feature#getKind <em>Kind</em>}</li>
 *   <li>{@link com.gh.funthomas424242.dsl.ube.ube.Feature#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.gh.funthomas424242.dsl.ube.ube.UbePackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link com.gh.funthomas424242.dsl.ube.ube.FeatureKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see com.gh.funthomas424242.dsl.ube.ube.FeatureKind
   * @see #setKind(FeatureKind)
   * @see com.gh.funthomas424242.dsl.ube.ube.UbePackage#getFeature_Kind()
   * @model required="true"
   * @generated
   */
  FeatureKind getKind();

  /**
   * Sets the value of the '{@link com.gh.funthomas424242.dsl.ube.ube.Feature#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see com.gh.funthomas424242.dsl.ube.ube.FeatureKind
   * @see #getKind()
   * @generated
   */
  void setKind(FeatureKind value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see com.gh.funthomas424242.dsl.ube.ube.UbePackage#getFeature_Type()
   * @model required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link com.gh.funthomas424242.dsl.ube.ube.Feature#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // Feature
