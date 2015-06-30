package com.goeuro.core.interfaces;

public interface ICSVFileGenerator {

	void appendln(ICSVPrintable vo);
	void close();
}
