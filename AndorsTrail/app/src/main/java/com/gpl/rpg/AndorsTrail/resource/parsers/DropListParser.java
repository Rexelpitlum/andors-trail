package com.gpl.rpg.AndorsTrail.resource.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.gpl.rpg.AndorsTrail.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail.model.item.DropList;
import com.gpl.rpg.AndorsTrail.model.item.DropList.DropItem;
import com.gpl.rpg.AndorsTrail.model.item.ItemTypeCollection;
import com.gpl.rpg.AndorsTrail.resource.parsers.json.JsonArrayParserFor;
import com.gpl.rpg.AndorsTrail.resource.parsers.json.JsonCollectionParserFor;
import com.gpl.rpg.AndorsTrail.resource.parsers.json.JsonFieldNames;
import com.gpl.rpg.AndorsTrail.util.L;
import com.gpl.rpg.AndorsTrail.util.Pair;
import org.json.JSONArray;


public final class DropListParser extends JsonCollectionParserFor<DropList> {

	private final JsonArrayParserFor<DropItem> dropItemParser;

	public DropListParser(final ItemTypeCollection itemTypes) {
		this.dropItemParser = new JsonArrayParserFor<DropItem>(DropItem.class) {
			@Override
			protected DropItem parseObject(JSONObject o) throws JSONException {
				return new DropItem(
						itemTypes.getItemType(o.getString(JsonFieldNames.DropItem.itemID))
						,ResourceParserUtils.parseChance(o.getString(JsonFieldNames.DropItem.chance))
						,ResourceParserUtils.parseQuantity(o.getJSONObject(JsonFieldNames.DropItem.quantity))
				);
			}
		};
	}

	@Override
	protected Pair<String, DropList> parseObject(JSONObject o) throws JSONException {
		String droplistID = o.getString(JsonFieldNames.DropList.dropListID);
		DropItem[] standardItems = dropItemParser.parseArray(o.getJSONArray(JsonFieldNames.DropList.items));
		String specialItemsJson="[\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"ring_shadow0\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"hunters_sword\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"rapier_lifesteal\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"elytharan_redeemer\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"Helm_foreseeing\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"yczorah2\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"gloves_life\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"shield_blk_defender\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"whip_bind\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"shadowfang\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"chaosreaper\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"valugha_gown\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"valugha_hat\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"clmr_wrmas\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"itemID\":\"gem_fire\",\n" +
				"\t\t\"chance\":\"1/10000\",\n" +
				"\t\t\"quantity\":{\n" +
				"\t\t\t\"min\":1,\n" +
				"\t\t\t\"max\":1\n" +
				"\t\t}\n" +
				"\t}\n" +
				"]";
		JSONArray specialItemsJsonArray= new JSONArray(specialItemsJson);
		DropItem[] specialItems= dropItemParser.parseArray(specialItemsJsonArray);
		DropItem[] items= new DropItem[standardItems.length + specialItems.length];
		System.arraycopy(standardItems,0,items,0,standardItems.length);
		System.arraycopy(specialItems,0,items,standardItems.length,specialItems.length);

		if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
			if (items == null) {
				L.log("OPTIMIZE: Droplist \"" + droplistID + "\" has no dropped items.");
			}
		}

		return new Pair<String, DropList>(droplistID, new DropList(items));
	}
}
