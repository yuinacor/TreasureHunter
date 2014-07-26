package model.dto.scene;

import java.util.HashMap;

import model.dto.script.Script;

public class Scene {
	public String key;
	public HashMap<String, Script> script;
	public int start;
	public int last;
}
