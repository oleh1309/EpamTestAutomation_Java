package com.epam.validators;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.File;
import java.io.IOException;

public class ValidatorsJSON {
    public static boolean validate(File jsonFile, File schemaFile) {
        ProcessingReport processingMessages = null;
        JsonNode jsonNode1;
        JsonNode jsonNode2;
        try {
            jsonNode1 = JsonLoader.fromFile(jsonFile);
            jsonNode2 = JsonLoader.fromFile(schemaFile);
            JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.byDefault();
            JsonValidator jsonValidator = jsonSchemaFactory.getValidator();
            processingMessages = jsonValidator.validate(jsonNode2, jsonNode1);
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
        assert processingMessages != null;
        return processingMessages.isSuccess();
    }
}
