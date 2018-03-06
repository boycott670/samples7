package com.sqli.nespresso.gossips;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

public class Gossips {
	
	private static enum Action
	{
		FROM,
		SAY;
	}

	public Gossips(final String... personNames)
	{
		for (final String personName : personNames)
		{
			final String realPersonName = personName.split("\\s+") [1];
			
			persons.put(realPersonName, new Person(realPersonName));
		}
	}

	private final Map<String, Person> persons = new LinkedHashMap<>();
	
	private String from;
	private Action action;
	private String salutations;
	
	public Gossips from (final String from)
	{
		action = Action.FROM;
		this.from = from;
		return this;
	}
	
	public Gossips to (final String to)
	{
		if (action == Action.FROM)
		{
			persons.get(from).setNext(persons.get(to));
		}
		else
		{
			persons.get(to).setSalutations(salutations);
		}
		
		return this;
	}
	
	public Gossips say (final String salutations)
	{
		action = Action.SAY;
		this.salutations = salutations;
		return this;	
	}
	
	public String ask (final String person)
	{
		return Optional.ofNullable(persons.get(person).getSalutations()).orElse("");
	}
	
	public void spread ()
	{
		for (final Entry<?, ? extends Person> entry : persons.entrySet())
		{
			if
			(
				!Objects.isNull(entry.getValue().getSalutations()) &&
				!Objects.isNull(entry.getValue().getNext())
			)
			{
				entry.getValue().getNext().setSalutations(entry.getValue().getSalutations());
				entry.getValue().setSalutations(null);
				break;
			}
		}
	}
	
}
