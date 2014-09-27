
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\math\AxisAlignedBB;
use pocketmine\Player;

class Carpet extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::CARPET, $meta, "Carpet");
		$names = [
			0 => "White Carpet",
			1 => "Orange Carpet",
			2 => "Magenta Carpet",
			3 => "Light Blue Carpet",
			4 => "Yellow Carpet",
			5 => "Lime Carpet",
			6 => "Pink Carpet",
			7 => "Gray Carpet",
			8 => "Light Gray Carpet",
			9 => "Cyan Carpet",
			10 => "Purple Carpet",
			11 => "Blue Carpet",
			12 => "Brown Carpet",
			13 => "Green Carpet",
			14 => "Red Carpet",
			15 => "Black Carpet",
		];
		$this->name = $names[$this->meta];
		$this->hardness = 0;
		$this->isFullBlock = false;
		$this->isSolid = true;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x,
			$this->y,
			$this->z,
			$this->x + 1,
			$this->y + 0.0625,
			$this->z + 1
		);
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->getID() !== self::AIR){
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->getID() === self::AIR){ //TODO: Replace with common break method
				$this->getLevel()->dropItem($this, Item::get($this->id, $this->meta, 1));
				$this->getLevel()->setBlock($this, new Air(), true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

}