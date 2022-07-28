package com.tokio.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculoTaxaException extends Exception{

    public CalculoTaxaException(String msg) {
        super(msg);
        log.warn(msg);
    }

}
