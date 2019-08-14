package com.bmaster.StreamingWebUI.Util.adls;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AdlsPathBuilder {
	
	private List<String> pathAry;
	private int depth;
	public AdlsPathBuilder() {
		this.depth = -1;
		pathAry = new LinkedList<String>();
	}
	public String AdlsPathAppend(String pth) {
		if(pth.equals("/")) {
			pathAry.add("");
			return pathBuilder();
		}
		pathAry.add(pth);
		depth++;
		return pathBuilder();
	}
	
	public String AdlsPathBack() {
		if(depth>-1) {
			this.pathAry.remove(depth+1);
			depth--;
		}
		return pathBuilder();
	}
	
	public String pathBuilder() {
		String tmp="";
		for(int i=0;i<this.pathAry.size();i++) {
			if(this.pathAry.get(i).equals("")) {
				continue;
			}
			tmp = tmp + "/" + this.pathAry.get(i); 
		}
		if(tmp.equals("")) {
			return "/";
		}
		return tmp;
	}
	
	@Override
	public String toString() {
		return pathBuilder();
	}
}
