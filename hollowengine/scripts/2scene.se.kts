val mindos by NPCEntity.creating {
    name = "Миндос"
    model = "is:models/npc/Mindos.gltf"
    textures["classic"] = ""
    showName = false
    pos = pos(-1528.5, 203, 70.5)
}
mindos.play {
	animation = "mindosmorgaet"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 1f
}
mindos.requestItems{
	+item("minecraft:emerald",5)
	+item("independent_storyline:wrench",1)
}

mindos say{"Добыл? Молодец."}
wait{2.sec}
mindos say{"Что же делать-то с тобой..."}
wait{2.sec}
mindos say{"Ай, ладно, возьмем тебя с собой."}
wait{2.sec}
mindos say{"Не оставлять же тебя погибать и гнить тут, жалко красавца."}

mindos.play {
	animation = "mindosmorgaet"
	layerMode = LayerMode.OVERWRITE
	playType = PlayMode.LOOPED
	speed = 0.3f
}
