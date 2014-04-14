package org.gluu.oxtrust.model;

import java.util.HashMap;
import java.util.Map;

import org.gluu.site.ldap.persistence.annotation.LdapEnum;

/**
 * SCIM Custom Attribute
 * 
 * @author Reda Zerrad Date: 08.02.2012
 */
public enum ScimCustomAtribute implements LdapEnum {

	TRUE("true", "True"), FALSE("false", "False");

	private String value;
	private String displayName;

	private static Map<String, ScimCustomAtribute> mapByValues = new HashMap<String, ScimCustomAtribute>();

	static {
		for (ScimCustomAtribute enumType : values()) {
			mapByValues.put(enumType.getValue(), enumType);
		}
	}

	private ScimCustomAtribute(String value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static ScimCustomAtribute getByValue(String value) {
		return mapByValues.get(value);
	}

	public Enum<? extends LdapEnum> resolveByValue(String value) {
		return getByValue(value);
	}

	@Override
	public String toString() {
		return value;
	}

}