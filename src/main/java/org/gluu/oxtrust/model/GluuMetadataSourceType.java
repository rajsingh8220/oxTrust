package org.gluu.oxtrust.model;

import java.util.HashMap;
import java.util.Map;

import org.gluu.site.ldap.persistence.annotation.LdapEnum;

/**
 * Metadata source type
 * 
 * @author Yuriy Movchan Date: 11.05.2010
 */
public enum GluuMetadataSourceType implements LdapEnum {

	FILE("file", "File"), URI("uri", "URI"), GENERATE("generate", "Generate"), FEDERATION("federation", "Federation");

	private String value;
	private String displayName;

	private static Map<String, GluuMetadataSourceType> mapByValues = new HashMap<String, GluuMetadataSourceType>();
	static {
		for (GluuMetadataSourceType enumType : values()) {
			mapByValues.put(enumType.getValue(), enumType);
		}
	}

	private GluuMetadataSourceType(String value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static GluuMetadataSourceType getByValue(String value) {
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