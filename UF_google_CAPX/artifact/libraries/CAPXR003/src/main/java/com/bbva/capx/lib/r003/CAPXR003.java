package com.bbva.capx.lib.r003;

import org.springframework.http.ResponseEntity;

public interface CAPXR003 {

	ResponseEntity<String> execute(String origin, String destination);

}
