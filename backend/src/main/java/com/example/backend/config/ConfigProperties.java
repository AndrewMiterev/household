package com.example.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ConfigurationProperties(prefix = "household")
@Validated
public class ConfigProperties {
	@NotBlank
	@Pattern(regexp = "\\[.+[^-_ ]\\]", message = "Regex: Forbidden characters for naming folders. All symbols, " +
			"filtered by regex, will be truncated. It is forbidden to define symbols: ' '(space), '-' and '_'")
	private String forbiddenFolderSymbolsRegex = "[,.':]";

	@Min(value = 1, message = "Minimum {value} threads to processing")
	@Max(value = 64, message = "Maximum {value} threads to processing")
	private Integer processingThreads = 4;

	@Min(value = 1, message = "Minimum {value} photos per processing")
	@Max(value = 10000, message = "Maximum {value}. (Comment from programmer: I think no more loaded photos per load period, next portion on next iteration)")
	private Integer processingNumberPhotosAtSameTime = 1000;

	@Min(value = 1000, message = "Minimum {value} milliseconds for delay between loads")
	@Max(value = 24 * 60 * 60 * 1000, message = "Maximum {value} milliseconds for delay between loads. (one day)")
	private Integer processingLoadDelayInMilliseconds = 10000;

	@Min(value = 1000, message = "Minimum {value} milliseconds for initial delay between loads")
	@Max(value = 24 * 60 * 60 * 1000, message = "Maximum {value} milliseconds for initial delay between loads. (one day)")
	private Integer processingLoadInitialDelayInMilliseconds = 20000;

	@Min(value = 10, message = "Minimum {value} milliseconds on tick delay of processing")
	@Max(value = 24 * 60 * 60 * 1000, message = "Maximum {value} milliseconds on tick delay of processing. (one day)")
	private Integer processingTickDelayInMilliseconds = 100;

	@Min(value = 10, message = "Minimum {value} milliseconds on initial tick delay of processing")
	@Max(value = 24 * 60 * 60 * 1000, message = "Maximum {value} milliseconds on initial tick delay of processing. (one day)")
	private Integer processingTickInitialDelayInMilliseconds = 100;
}
