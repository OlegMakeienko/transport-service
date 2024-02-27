package com.makeienko.communaltransport.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DelayUpdateRequest {
    private String delayReport;
    private String estimatedDelay;
}
