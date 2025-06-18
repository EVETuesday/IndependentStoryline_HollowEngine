val players by server.players
val player = players().first()

gui {
	image("is:textures/gui/selection_screen/bgr_1.png") {
		size(350.px, 256.px)
	}
	entity(player) {
		scale = 2f
		offset((-123).px, (-20).px)
	}
	image("is:textures/gui/selection_screen/bgr_2.png") {
		size(350.px, 256.px)
	}
	label("Вопрос?") {
		anchor = Anchor.START
		offset(15.px, (-70).px)
		scale = 1.5f
	}
	button("", "is:textures/gui/selection_screen/empty.png") {
		size(230.px, 15.px)
		offset(25.px, (-20).px)
		onClick = {
			close()
		}
	}
	label("Вариант 1") {
		anchor = Anchor.START
		offset(17.px, (-25).px)
		scale = 1.2f
	}
	button("", "is:textures/gui/selection_screen/empty.png") {
		size(230.px, 15.px)
		offset(25.px, (-0).px)
		onClick = {
			close()
		}
	}
	label("Вариант 2") {
		anchor = Anchor.START
		offset(17.px, (-5).px)
		scale = 1.2f
	}
	button("", "is:textures/gui/selection_screen/empty.png") {
		size(230.px, 15.px)
		offset(25.px, (20).px)
		onClick = {
			close()
		}
	}
	label("Вариант 3") {
		anchor = Anchor.START
		offset(17.px, (15).px)
		scale = 1.2f
	}
}
