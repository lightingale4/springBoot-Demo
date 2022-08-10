package org.dingli.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ding.li
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MingYueUser {

    private Long userId;

    private String username;
}
