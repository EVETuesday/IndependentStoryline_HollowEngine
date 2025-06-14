var players by server.players
var player = players().first()

val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/modium.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 350f,
        "minecraft:generic.movement_speed" to 0.4f, //к примеру здоровье
    )
    //animations[AnimationType.IDLE] = "modiummorg"
    animations[AnimationType.WALK] = "walk"
    //animations[AnimationType.SWING] = "kickradius2"
    showName = true //показывать ли ник с именем над нпс
    pos = pos(-1531.54, 291.06, -206.78) //координаты где спавнить нпс
    showName = false
}
modium giveRightHand { item("simplyswords:runic_cutlass") }

var modium_is_alive: Boolean = true

var npcEntity = NPCEntity(player.level)
next {
 npcEntity = modium.invoke()!!
}

next{npcEntity.setHealth(350f)}
modium lookAt {player}

execute{"/bind_enhanced_boss_bar @e[name=\"Модиум\",limit=1]"}

//modium moveAlwaysTo {player}


val bit_time: Int = 10

async{
	While({modium_is_alive})
	{
	wait{1.sec}
	next{ player = players().first()}
	}

}

async{
While ({modium_is_alive})
{
If({modium_is_alive})
{
	modium setTarget{player}
	modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	
	var j = 1
	While({j<=bit_time})
	{
		If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		}
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1531.54, 291.06, -206.78)}
}
If({modium_is_alive})
{

	modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	modium setTarget{player}}
	
	
	var j = 1
	While({j<=bit_time})
	{
		If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		}
	
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1546.70, 292.00, -194.44)}


If({modium_is_alive})
{
	modium setTarget{player}
	modium lookAt {player}
	modium giveLeftHand { item("independent_storyline:stone_stylet") }
			modium play{
			animation = "kickbrosok" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		modium giveLeftHand {null}
    		wait{10}
    		execute({"/attack1 @e[name=\"Модиум\",limit=1]"})
		modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	
	var j = 1
	While({j<=bit_time})
	{
	
	If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		
		}
	
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1514.41, 291.00, -213.36)}
}


If({modium_is_alive})
{
	modium setTarget{player}
	modium lookAt {player}
	modium giveLeftHand { item("independent_storyline:stone_stylet") }
			modium play{
			animation = "kickbrosok" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		modium giveLeftHand {null}
    		wait{10}
    		execute({"/attack1 @e[name=\"Модиум\",limit=1]"})
		modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	
	var j = 1
	While({j<=bit_time})
	{
	
	If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		
		}
	
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1515.70, 292.00, -195.51)}
}


If({modium_is_alive})
{
	modium setTarget{player}
	modium lookAt {player}
	modium giveLeftHand { item("independent_storyline:stone_stylet") }
			modium play{
			animation = "kickbrosok" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		modium giveLeftHand {null}
    		wait{10}
    		execute({"/attack1 @e[name=\"Модиум\",limit=1]"})
		modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	
	var j = 1
	While({j<=bit_time})
	{
	
	If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		
		}
	
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1544.48, 292.00, -225.50)}
}

If({modium_is_alive})
{
	modium setTarget{player}
	modium lookAt {player}
	modium giveLeftHand { item("independent_storyline:stone_stylet") }
			modium play{
			animation = "kickbrosok" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		modium giveLeftHand {null}
    		wait{10}
    		execute({"/attack1 @e[name=\"Модиум\",limit=1]"})
		modium play{
	animation = "justkick" // Название анимации
    layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    speed = 0.5f // Скорость анимации
	}
	
	var j = 1
	While({j<=bit_time})
	{
	
	If({bit_time/j==2})
		{
			modium play{
			animation = "kickradius" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 0.5f // Скорость анимации
    		}
    		execute({"/attack2 @e[name=\"Модиум\",limit=1]"})
    			modium play{
				animation = "justkick" // Название анимации
    			layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
   			 	playType = PlayMode.ONCE // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    			speed = 0.5f // Скорость анимации
				}
		
		}
	
		If({modium_is_alive})
		{
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1529.67, 294.19, -187.53)}
}
}
}
next{modium_is_alive = true}
While ({modium_is_alive})
{
	var a: Float = npcEntity.getHealth()
	next {a = npcEntity.getHealth()}
	//execute{"/say "+a.toString()}
	If ({a<19f})
	{
		next{modium_is_alive=false}
		modium.clearTarget()
	}
}
modium.clearTarget()
modium lookAlwaysAt {player}
modium.invulnerable = true
execute{"/unbind_enhanced_boss_bar @e[name=\"Модиум\",limit=1]"}
modium lookAlwaysAt {pos(-1529.67, 0.19, -187.53)}
modium play{
			animation = "lose" // Название анимации
    		layerMode = LayerMode.ADD // Режим сложения анимаций. Есть: ADD - добавить к текущему положению ещё анимацию. OVERWRITE - полностью перезаписать другие анимации.
    		playType = PlayMode.LAST_FRAME // Режим проигрывания анимаций. Есть: ONCE - 1 раз, LOOPED - в цикле, LAST_FRAME - остановиться на последнем кадре, REVERSED - в цикле, но после завершения в обратную сторону
    		speed = 1f // Скорость анимации
    		}
modium say{"Ладно, всё, достаточно"}
wait{4.sec}
players say{"Я же просил тебя сдаться. Я не хотел прибегать к такому"}
wait{4.sec}
modium say{"Тебе не понять, малец. Добивай. "}
wait{4.sec}
modium say{"Знай, что мои последователи продолжат мое дело. Все так просто не кончится. "}
wait{6.sec}

var choice_result = true
dialogue {
	choice(ChoiceAction.WORLD){
		players say{"Я убийца?"}
		"Я Добью тебя!"{
		modium.invulnerable = false
		execute{"/bind_enhanced_boss_bar @e[name=\"Модиум\",limit=1]"}
			players say{"Убить"}
			choice_result = true
		}
		"Сохранить ему жизнь"{
			players say{"Я сохраню тебе жизнь..."}
			choice_result = false
		}
	}
}
