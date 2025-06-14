val players by server.players
val player = players().first()

val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/gerdec.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 350f,
        "minecraft:generic.movement_speed" to 0.4f, //к примеру здоровье
    )
    showName = true //показывать ли ник с именем над нпс
    pos = pos(-1531.54, 291.06, -206.78) //координаты где спавнить нпс
    showName = false
    //animations[AnimationType.IDLE] = "modiummorg"
    //animations[AnimationType.WALK] = "modiumsmeh"
    //animations[AnimationType.SWING] = "kickradius2"
}
//modium giveRightHand { item("simplyswords:runic_cutlass") }
//modium lookAlwaysAt {player}
//modium setTarget{player}





var npcEntity = NPCEntity(player.level)
next {
 npcEntity = modium.invoke()!!
}
execute({"/say "+npcEntity.getStringUUID()}) 

modium play{
animation = "angry" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.LOOPED // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 1f // Скорость анимации
}






