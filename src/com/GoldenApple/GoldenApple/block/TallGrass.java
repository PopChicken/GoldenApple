
use pocketmine\item\Item;
use pocketmine\level\Level;

class TallGrass extends Flowable{
	public function __construct($meta = 1){
		parent::__construct(self::TALL_GRASS, $meta, "Tall Grass");
		$this->isReplaceable = true;
		$names = [
			0 => "Dead Shrub",
			1 => "Tall Grass",
			2 => "Fern",
		];
		$this->name = $names[$this->meta & 0x03];
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

	public function getDrops(Item $item){
		if(mt_rand(0, 15) === 0){
			return [Item::WHEAT_SEEDS, 0, 1];
		}

		return [];
	}

}