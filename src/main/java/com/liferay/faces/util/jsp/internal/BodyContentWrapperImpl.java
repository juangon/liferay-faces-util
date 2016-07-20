package com.liferay.faces.util.jsp.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

public class BodyContentWrapperImpl extends BodyContent {
	
	private BodyContent wrappedBodyContent;
	private JspWriter jspWriter;

	public BodyContentWrapperImpl(BodyContent bodyContent, JspWriter writer) {
		super(bodyContent.getEnclosingWriter());
		wrappedBodyContent = bodyContent;
		jspWriter  = writer;
	}

	@Override
	public Reader getReader() {
		return wrappedBodyContent.getReader();
	}

	@Override
	public String getString() {
		return jspWriter.toString();
	}

	@Override
	public void writeOut(Writer out) throws IOException {
		wrappedBodyContent.writeOut(out);
	}

	@Override
	public void newLine() throws IOException {
		wrappedBodyContent.newLine();
	}

	@Override
	public void print(boolean b) throws IOException {
		wrappedBodyContent.print(b);
	}

	@Override
	public void print(char c) throws IOException {
		wrappedBodyContent.print(c);
	}

	@Override
	public void print(int i) throws IOException {
		wrappedBodyContent.print(i);
	}

	@Override
	public void print(long l) throws IOException {
		wrappedBodyContent.print(l);
	}

	@Override
	public void print(float f) throws IOException {
		wrappedBodyContent.print(f);
	}

	@Override
	public void print(double d) throws IOException {
		wrappedBodyContent.print(d);
	}

	@Override
	public void print(char[] s) throws IOException {
		wrappedBodyContent.print(s);
	}

	@Override
	public void print(String s) throws IOException {
		wrappedBodyContent.print(s);
	}

	@Override
	public void print(Object obj) throws IOException {
		wrappedBodyContent.print(obj);
	}

	@Override
	public void println() throws IOException {
		wrappedBodyContent.println();
	}

	@Override
	public void println(boolean x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(char x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(int x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(long x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(float x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(double x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(char[] x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(String x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void println(Object x) throws IOException {
		wrappedBodyContent.println(x);
	}

	@Override
	public void clear() throws IOException {
		jspWriter.clear();;
	}

	@Override
	public void clearBuffer() throws IOException {
		jspWriter.clearBuffer();
	}

	@Override
	public void close() throws IOException {
		wrappedBodyContent.close();
	}

	@Override
	public int getRemaining() {
		return wrappedBodyContent.getRemaining();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		wrappedBodyContent.write(cbuf, off, len);
	}

}
