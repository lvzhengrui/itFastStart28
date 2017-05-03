package org.lvzr.fast.test.unitils;

import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;


@SpringApplicationContext({"spring/not-released/foundation-base-ctx.xml"
	,"spring/not-released/foundation-cache-ctx.xml"})
public class TestUnitils{
	

    @SpringBeanByType
    private DictManager dictManager;
    
    
    
	
}