package com.udemy.model;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    private int messageId;

    @NotNull
    private int accountId;

    @NotNull
    private int experimentId;

    @NotNull
    @Length(max=150)
    private String bericht;

    @NotNull
    private String dateTime;
}
