

class WallSign extends SignPost{
	public function __construct($meta = 0){
		Transparent::__construct(self::WALL_SIGN, $meta, "Wall Sign");
	}

	public function getBoundingBox(){
		return null;
	}


	public function onUpdate($type){
		return false;
	}
}