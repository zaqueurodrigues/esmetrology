package com.zaqueurodrigues.esmetrology.log;

import org.apache.logging.log4j.Level;

public enum EsmetrologyLogType {
	
	
	FATAL( Level.FATAL ), ERROR( Level.ERROR ), INFO( Level.INFO ), DEBUG( Level.DEBUG ), WARNING( Level.WARN ), TRACE( Level.TRACE );
	
	private Level equivalentLog4jLevel;
	
	
	EsmetrologyLogType ( Level equivalentLog4jLevel ){
		this.equivalentLog4jLevel = equivalentLog4jLevel;
	}
	
	
	public boolean isEquivalent(Level logLevel) {
		return equivalentLog4jLevel.isMoreSpecificThan( logLevel );
	}

}
