
use pocketmine\level\Level;

class DeadBush extends Flowable{
	public function __construct(){
		parent::__construct(self::DEAD_BUSH, 0, "Dead Bush");
		//$this->isReplaceable = true;
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}


	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //Replace with common break method
				$this->getLevel()->setBlock($this, new Air(), false, false, true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

}