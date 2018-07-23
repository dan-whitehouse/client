package org.ricone.api.client.request2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class ChangesSince {
    private LocalDateTime opaqueMarker;

    ChangesSince(LocalDateTime opaqueMarker) {
        this.opaqueMarker = opaqueMarker;
    }

    public boolean hasOpaqueMarker() {
        return opaqueMarker != null;
    }

    String iso8601() {
        return opaqueMarker.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
