
use pocketmine\math\AxisAlignedBB;

class EndPortal extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::END_PORTAL, $meta, "End Portal");
		$this->hardness = 18000000;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x,
			$this->y,
			$this->z,
			$this->x + 1,
			$this->y + (($this->getDamage() & 0x04) > 0 ? 1 : 0.8125),
			$this->z + 1
		);
	}
}