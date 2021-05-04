package com.jwebmp.core.base.angular.forms;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class AngularSelectOption extends JavaScriptPart<AngularSelectOption>
{
	private String id;
	private String name;
	private boolean selected;
	
	public String getId()
	{
		return id;
	}
	
	public AngularSelectOption setId(String id)
	{
		this.id = id;
		return this;
	}
	
	public String getName()
	{
		return name;
	}
	
	public AngularSelectOption setName(String name)
	{
		this.name = name;
		return this;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public AngularSelectOption setSelected(boolean selected)
	{
		this.selected = selected;
		return this;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		AngularSelectOption that = (AngularSelectOption) o;
		return Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(getId());
	}
}
